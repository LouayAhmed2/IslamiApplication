package com.route.islami


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islami.adapter.SuraAdapter
import kotlinx.android.synthetic.main.fragment_suras.*

/**
 * A simple [Fragment] subclass.
 */
class SurasFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_suras, container, false)
    }

    lateinit var adapter: SuraAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = SuraAdapter(Constants.suraNames)
        recycler_view.adapter =adapter
        adapter.onItemClickListener =
            object :SuraAdapter.OnItemClickListener{
                override fun onItemClick(pos: Int, item: String) {
                    val intent = Intent(context,
                        SuraDetailsActivity::class.java)
                    intent.putExtra(Constants.EXTRA_SURA_POSISTION,pos)
                    intent.putExtra(Constants.EXTRA_SURA_NAME,item)
                    startActivity(intent)
                }
            };

    }


}
