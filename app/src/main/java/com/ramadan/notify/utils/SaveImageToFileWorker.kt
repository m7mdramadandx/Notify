package com.ramadan.notify.utils

import android.content.Context
import android.graphics.BitmapFactory
import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.ramadan.notify.utils.Constant.KEY_IMAGE_URI
import java.io.InputStream
import java.net.URL
import java.text.SimpleDateFormat
import java.util.*


/**
 * Saves the image to a permanent file
 */

class SaveImageToFileWorker(ctx: Context, params: WorkerParameters) : Worker(ctx, params) {

    private val Title = "Blurred Image"
    private val dateFormatter = SimpleDateFormat(
        "yyyy.MM.dd 'at' HH:mm:ss z",
        Locale.getDefault()
    )

    override fun doWork(): Result {
        // Makes a notification when the work starts and slows down the work so that
        // it's easier to see each WorkRequest start, even on emulated devices
        makeStatusNotification("Saving image", applicationContext)
        sleep()

        val resolver = applicationContext.contentResolver
        return try {

            val resourceUri = inputData.getString(KEY_IMAGE_URI)
            val inputStream = resolver.openInputStream(Uri.parse(resourceUri))
            val `in`: InputStream = URL(Uri.parse(resourceUri).toString()).openStream()

            val bitmap = BitmapFactory.decodeStream(`in`,null,BitmapFactory.Options())

//            if (Build.VERSION.SDK_INT >= Q) {
//                val contentValues = ContentValues()
//                contentValues.put(MediaStore.MediaColumns.DISPLAY_NAME, Title)
//                contentValues.put(MediaStore.Files.FileColumns.MIME_TYPE, "image/png")
//                contentValues.put(MediaStore.MediaColumns.RELATIVE_PATH, "relativePath")
//                contentValues.put(MediaStore.MediaColumns.IS_PENDING, 1)
//            }

            val imageUrl = MediaStore.Images.Media.insertImage(
                resolver, bitmap, Title, dateFormatter.format(Date())
            )
            if (!imageUrl.isNullOrEmpty()) {
                val output = workDataOf(KEY_IMAGE_URI to imageUrl)

                Result.success(output)
            } else {
                Log.e(Constant.DEBUG_TAG, "Writing to MediaStore failed")
                Result.failure()
            }
        } catch (exception: Exception) {
            Log.e(Constant.DEBUG_TAG, exception.message.toString())
            exception.printStackTrace()
            Result.failure()
        }
    }
}