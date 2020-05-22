package com.route.islami

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.route.islami.adapter.VersesAdapter
import kotlinx.android.synthetic.main.activity_sura_details.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader


class SuraDetailsActivity : AppCompatActivity() {

    lateinit var adapter: VersesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)
        val suraName = intent.getStringExtra(Constants.EXTRA_SURA_NAME)
        val suraPos =
            intent.getIntExtra(Constants.EXTRA_SURA_POSISTION,-1)
        suraNameTextView.setText(suraName)
      //  val versesList = readSuraFile(""+ (suraPos+1)+".txt")
        val versesList = readSuraFile("${suraPos+1}.txt")
        adapter= VersesAdapter(versesList)
        recycler_view.adapter = adapter
    }

    fun readSuraFile(fileName:String):List<String>{
        val versesList = mutableListOf<String> ()
        val reader: BufferedReader
        try {
            val file: InputStream = assets.open(fileName)
            reader = BufferedReader(InputStreamReader(file))
            var line: String? = reader.readLine()
            while (line != null) {
                versesList.add(line)
                line = reader.readLine()
            }
        } catch (ioe: IOException) {
            ioe.printStackTrace()
        }
        return versesList
    }
}
