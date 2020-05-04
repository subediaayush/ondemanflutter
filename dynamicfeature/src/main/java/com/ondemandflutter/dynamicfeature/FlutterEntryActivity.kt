package com.ondemandflutter.dynamicfeature

import android.content.Context
import com.google.android.play.core.splitcompat.SplitCompat
import io.flutter.embedding.android.FlutterActivity

class FlutterEntryActivity : FlutterActivity() {

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
        SplitCompat.installActivity(this)
    }

    class EngineBuilder: NewEngineIntentBuilder(FlutterEntryActivity::class.java)
}
