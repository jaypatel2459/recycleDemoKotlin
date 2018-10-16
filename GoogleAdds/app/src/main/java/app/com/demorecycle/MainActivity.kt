package app.com.demorecycle

import android.app.Activity
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import app.com.demorecycle.adapters.AnimalAdapter
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {

    private val animals: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this, getString(R.string.add_app_id))
        initView()
    }

    private fun initView(){
        val adRequest = AdRequest.Builder().build()
        adViewMain.loadAd(adRequest)

        addAnimals()
        val animalAdapter = AnimalAdapter(animals, this)

        setLayoutType(true)

        actionBtn.setOnClickListener {
            if(rv_animal_list.layoutManager is GridLayoutManager){
                setLayoutType(false)
            }else{
                setLayoutType(true)
            }
        }

        // Access the RecyclerView Adapter and load the data into it
        rv_animal_list.adapter = animalAdapter
    }

    // Adds animals to the empty animals ArrayList
    private fun addAnimals() {
        animals.add("dog")
        animals.add("cat")
        animals.add("owl")
        animals.add("cheetah")
        animals.add("raccoon")
        animals.add("bird")
        animals.add("snake")
        animals.add("lizard")
        animals.add("hamster")
        animals.add("bear")
        animals.add("lion")
        animals.add("tiger")
        animals.add("horse")
        animals.add("frog")
        animals.add("fish")
        animals.add("shark")
        animals.add("turtle")
        animals.add("elephant")
        animals.add("cow")
        animals.add("beaver")
        animals.add("bison")
        animals.add("porcupine")
        animals.add("rat")
        animals.add("mouse")
        animals.add("goose")
        animals.add("deer")
        animals.add("fox")
        animals.add("moose")
        animals.add("buffalo")
        animals.add("monkey")
        animals.add("penguin")
        animals.add("parrot")
    }

    private fun setLayoutType(isGrid: Boolean){
        if(isGrid){
            // You can use GridLayoutManager if you want multiple columns. Enter the number of columns as a parameter.
            rv_animal_list.layoutManager = GridLayoutManager(this, 2).also {
                it.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                    override fun getSpanSize(position: Int): Int {
                        return if ((position +1) % 5 == 0)
                            2
                        else
                            1
                    }
                }
            }
            actionBtn.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_list))
            actionBtn.drawable.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP)
        }else{
            // You can set linear layout here
            rv_animal_list.layoutManager = LinearLayoutManager(this)
            actionBtn.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_grid))
            actionBtn.drawable.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP)

        }
    }
}
