package com.ondemandflutter.dynamicfeature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.flutter.embedding.android.FlutterActivity

class FlutterEntry : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FlutterActivity.withNewEngine().build(this).apply {
            startActivity(this)
        }

        finish()
    }
}
