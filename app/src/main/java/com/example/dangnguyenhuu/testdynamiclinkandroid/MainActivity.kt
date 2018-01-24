package com.example.dangnguyenhuu.testdynamiclinkandroid

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.customtabs.CustomTabsIntent
import android.util.Log
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        this.webOpenButton.setOnClickListener {

            val builder = CustomTabsIntent.Builder()
            val tabIntent = builder.setShowTitle(true)
                    .enableUrlBarHiding().build()

            tabIntent.launchUrl(this, Uri.parse("https://qiita.com/hikariraina/items/1fb65805b57cff557d5e"))
        }


        this.dynamicLinkButton.setOnClickListener {

            val builder = CustomTabsIntent.Builder()
            val tabIntent = builder.setShowTitle(true)
                    .enableUrlBarHiding().build()

//            tabIntent.launchUrl(this, Uri.parse("https://c6nwy.app.goo.gl/kCdB"))
            tabIntent.launchUrl(this, Uri.parse("http://www.example.com/gizmos"))
        }

        FirebaseDynamicLinks.getInstance()
                .getDynamicLink(getIntent())
                .addOnSuccessListener { test ->
                    Log.d("Dang  ----> ", "  test")

                }
    }
}
