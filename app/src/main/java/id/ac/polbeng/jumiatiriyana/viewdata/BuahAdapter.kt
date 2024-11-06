package id.ac.polbeng.jumiatiriyana.viewdata

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.ac.polbeng.jumiatiriyana.viewdata.databinding.ListItemBinding

class BuahAdapter(
    private val context: Context,
    private val dataBuah: Array<String>,
    private val dataGambar: Array<Int>
) : RecyclerView.Adapter<BuahAdapter.BuahHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuahHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BuahHolder(binding)
    }

    // Set data ke RecyclerView
    override fun onBindViewHolder(holder: BuahHolder, position: Int) {

        holder.binding.tvNamaBuah.text = dataBuah[position]
        holder.binding.imgBuah.setImageResource(dataGambar[position])
        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailBuahActivity::class.java)
            intent.putExtra("nama", dataBuah[position])
            intent.putExtra("gambar", dataGambar[position])
            context.startActivity(intent)
        }
    }

    // Tampilkan data
    override fun getItemCount(): Int = dataBuah.size

    // Deklarasi id pada customAdapter, id yang ada pada list_item
    inner class BuahHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)
}
