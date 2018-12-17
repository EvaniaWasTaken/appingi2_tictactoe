package fr.epita.tictactoe

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ListAdapter(
    private val context: Context,
    private val data: MutableList<Score>) : BaseAdapter() {
    override fun getCount(): Int {
        // returns the number of items in this adapter
        // usually the size of the underlying List/Array...
        return data.size
    }

    override fun getItem(position: Int): Score {
        // returns the data item at the specified position in the list
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        // return the ID of the specified row (customized or row position)
        return position.toLong()
    }
    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup?): View {
        // first let us retrieve the item at the specified position
        val currentItem: Score = getItem(position)
        // now we build a view
        // first step, acquire a LayoutInflater
        val layoutInflater = LayoutInflater.from(context)
        // now use this LayoutInflater to inflate our row layout resource
        // into a View
        val rowView = layoutInflater.inflate(
            R.layout.row,
            parent,
            false
        );
        // bind variables to the distinct views inside our row view
        val nameTextView = rowView.findViewById<TextView>(R.id.score_player_name)
        // finally, time to put the data in here
        nameTextView.text = currentItem.PlayerName
        // job’s done, the view is built and contains the data for the
        // requested position, we can return it to the system
        return rowView;
    }
}