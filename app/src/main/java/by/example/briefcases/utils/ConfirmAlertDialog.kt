package by.example.briefcases.utils

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import by.example.briefcases.R

class ConfirmAlertDialog(
    private val context: Context,
    private val title: String,
    private val message: String,
    private val confirm: () -> Unit
) {
    fun createAlertDialog(): AlertDialog = AlertDialog.Builder(context)
        .setTitle(title)
        .setMessage("Are you sure that your ${title.lowercase()} is $message?")
        .setPositiveButton(
            R.string.continue_button,
            DialogInterface.OnClickListener { dialogInterface, _ ->
                dialogInterface.apply {
                    dismiss()
                    confirm()
                }
            })
        .setNegativeButton(R.string.cancel, DialogInterface.OnClickListener { dialog, _ ->
            dialog.cancel()
        })
        .create()
}

fun ConfirmAlertDialog.show() {
    this.show()
}