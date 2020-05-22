package com.route.islami

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.route.islami.Api.ApiManger
import com.route.islami.Api.RadiosItem
import com.route.islami.Api.RadiosRisponse
import com.route.islami.adapter.RadioChannelAdapter
import kotlinx.android.synthetic.main.fragment_radio.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 */
class RadioFragment : Fragment() {
val adapter=RadioChannelAdapter(null)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_radio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerr_view.adapter=adapter
        ApiManger.getWebService()?.getRadioChannels()?.enqueue(object :Callback<RadiosRisponse>{
            override fun onFailure(call: Call<RadiosRisponse>, t: Throwable) {

                Log.e("Error",t.localizedMessage.toString())


            }

            override fun onResponse(
                call: Call<RadiosRisponse>,
                response: Response<RadiosRisponse>
            ) {

                progressbar.visibility=View.GONE
                adapter.ChangeData(response.body()?.radios)

            }
        })
        adapter.onPlayClickListener=object : RadioChannelAdapter.OnItemClickListener{
            override fun onItemClick(pos: Int, item: RadiosItem?) {
                 playchannel(item?.uRL)
            }

        }
        adapter.onStopClickListener=object : RadioChannelAdapter.OnItemClickListener{
            override fun onItemClick(pos: Int, item: RadiosItem?) {

                Stopradio()
            }

        }
    }
var mediaPlayer:MediaPlayer?=null
    private fun playchannel(uRL: String?) {
        Stopradio()
        if (uRL==null)return
        mediaPlayer= MediaPlayer()
        mediaPlayer?.setDataSource(uRL)
        mediaPlayer?.prepareAsync()
mediaPlayer?.setOnPreparedListener(MediaPlayer.OnPreparedListener {
    it.start()
})


    }

    private fun Stopradio() {
        mediaPlayer?.stop()


    }

}
