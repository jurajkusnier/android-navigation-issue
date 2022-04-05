package com.juraj.navigationissue.ui.main

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.app.NotificationChannelCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavDeepLinkBuilder
import com.juraj.navigationissue.MainActivity
import com.juraj.navigationissue.R

class FragmentA : Fragment(R.layout.fragment_a) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.notification_button).setOnClickListener {
            showNotification(requireContext())
        }
    }

    private fun showNotification(context: Context) {
        val notificationManager = NotificationManagerCompat.from(context)

        val intent = NavDeepLinkBuilder(context)
            .setGraph(R.navigation.nav_graph)
            .setComponentName(MainActivity::class.java)
            .setDestination(R.id.fragmentB)
            .createPendingIntent()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            setupChannel(notificationManager)
        }

        val notification = NotificationCompat.Builder(context, CHANNEL_ID).apply {
            setContentTitle("NOTIFICATION")
            setContentText("Open Fragment B")
            setSmallIcon(R.drawable.ic_baseline_notifications_24)
            setContentIntent(intent)
        }.build()

        notificationManager.notify(NOTIFICATION_ID, notification)
    }

    private fun setupChannel(notificationManager: NotificationManagerCompat) {
        val channel = NotificationChannelCompat.Builder(
            CHANNEL_ID,
            NotificationManagerCompat.IMPORTANCE_DEFAULT
        )
            .setName("Notifications")
            .setDescription("")
            .build()

        notificationManager.createNotificationChannel(channel)
    }

    companion object {
        private const val CHANNEL_ID = "com.juraj.navigationissue.notificationchannel"
        private const val NOTIFICATION_ID = 9999
    }

}