package ca.teamdman.notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var id = 0

    fun sendMessage(view: View) {
        var channel = NotificationChannel("beans", "Beans", NotificationManager.IMPORTANCE_DEFAULT)
        channel.lightColor = Color.GREEN;
        var nm = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        nm.createNotificationChannel(channel)
        var builder = NotificationCompat.Builder(this, channel.id)
            .setSmallIcon(androidx.core.R.drawable.notification_icon_background)
            .setContentTitle("My title")
            .setContentText("My content")
            .setAutoCancel(true)
        with(NotificationManagerCompat.from(this)) {
            notify(id++, builder.build())
        }
        println("benans")
        // do something
    }
}