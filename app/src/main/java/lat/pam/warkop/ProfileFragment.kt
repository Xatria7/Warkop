package lat.pam.warkop

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvGreeting = view.findViewById<TextView>(R.id.tvGreeting)
        val etNama = view.findViewById<EditText>(R.id.etNama)

        val nama = UserPrefs.getNama(requireContext())
        tvGreeting.text = "Halo $nama,"
        etNama.setText(nama)

        view.findViewById<Button>(R.id.btnSave).setOnClickListener {
            val baru = etNama.text.toString().trim()
            if (baru.isEmpty()) {
                Toast.makeText(requireContext(), "Nama tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else {
                UserPrefs.setNama(requireContext(), baru)
                tvGreeting.text = "Halo $baru,"
                Toast.makeText(requireContext(), "Profile tersimpan", Toast.LENGTH_SHORT).show()
            }
        }
    }
}