package com.ondemandflutter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.play.core.splitcompat.SplitCompat
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest
import com.google.android.play.core.splitinstall.SplitInstallSessionState
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus.*

class MainActivity : AppCompatActivity(), SplitInstallStateUpdatedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startFlutter(view: View? = null) {
        val installManager = SplitInstallManagerFactory.create(this)
        val module = "dynamicfeature"
        if (module in installManager.installedModules) {
            val entry = "com.ondemandflutter.dynamicfeature.FlutterEntry"
            startActivity(Intent(this, Class.forName(entry)))
        } else {
            installManager.registerListener(this)
            val installRequest = SplitInstallRequest.newBuilder().addModule(module).build()
            installManager.startInstall(installRequest)
        }
    }

    override fun onStateUpdate(state: SplitInstallSessionState?) {
        when (state?.status()) {
            INSTALLED -> startFlutter()
            REQUIRES_USER_CONFIRMATION -> {
                val installManager = SplitInstallManagerFactory.create(this)
                installManager.startConfirmationDialogForResult(state, this, 2123)
            }
            INSTALLING -> {
                Toast.makeText(this, "Installing flutter", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
        SplitCompat.installActivity(this)
    }
}
