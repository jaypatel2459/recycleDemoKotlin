package app.com.demorecycle.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.com.demorecycle.R
import com.google.android.gms.ads.AdRequest
import kotlinx.android.synthetic.main.add_list_item.view.*
import kotlinx.android.synthetic.main.animal_list_item.view.*


class AnimalAdapter(private val items: ArrayList<String>, private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var ItemView = 1
    private var AddView = 2
    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    override fun getItemViewType(position: Int): Int {

        if ((position + 1) % 5 == 0 && (position + 1) > 0) {
            return AddView
        } else {
            return ItemView
        }

    }

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == AddView) {
            return ViewHolderAdd(LayoutInflater.from(context).inflate(R.layout.add_list_item, parent, false))
        } else {

            return ViewHolder(LayoutInflater.from(context).inflate(R.layout.animal_list_item, parent, false))
        }
    }

    // Binds each animal in the ArrayList to a view
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (getItemViewType(position) == ItemView) {
            (holder as ViewHolder).tvAnimalType.text = items.get(position)
        } else if (getItemViewType(position) == AddView) {

            val adRequest = AdRequest.Builder().build()
            (holder as ViewHolderAdd).adView.loadAd(adRequest)
        }
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each animal to
    val tvAnimalType = view.tv_animal_type!!
}

class ViewHolderAdd(view: View) : RecyclerView.ViewHolder(view) {
    val adView = view.adView!!
}