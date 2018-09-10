package gswierczynski.pl.noonnestedscrollduringflingonsupp28rc1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.plant(object : Timber.DebugTree() {
            override fun createStackElementTag(element: StackTraceElement): String {
                return super.createStackElementTag(element) + ".${element.methodName}"
            }
        })
        setContentView(R.layout.activity_main)
        recyclerView.adapter = RecyclerAdapter((1..1000).map { Item() })
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}

class RecyclerAdapter(private val items: List<Item>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
            ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {}
}

class Item

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
