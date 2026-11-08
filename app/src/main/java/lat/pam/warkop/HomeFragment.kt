package lat.pam.warkop

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val menuList = listOf(
        MenuItem("Kopi Susu Gula Aren", "Espresso, susu, gula aren", "Rp 22.000"),
        MenuItem("Donat Cokelat", "Donat empuk, glaze cokelat", "Rp 12.000"),
        MenuItem("Sourdough Loaf", "Roti fermentasi alami", "Rp 35.000"),
        MenuItem("Cappuccino", "Espresso, foam susu lembut", "Rp 25.000"),
        MenuItem("Matcha Latte", "Matcha Jepang, susu segar", "Rp 27.000")
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nama = UserPrefs.getNama(requireContext())
        view.findViewById<TextView>(R.id.tvGreeting).text = "Halo $nama,"

        val spanCount = resources.getInteger(R.integer.menu_span_count)
        val rv = view.findViewById<RecyclerView>(R.id.rvMenu)
        rv.layoutManager = GridLayoutManager(requireContext(), spanCount)
        rv.adapter = MenuAdapter(menuList)
    }
}