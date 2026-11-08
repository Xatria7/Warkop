package lat.pam.warkop

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class OrderFragment : Fragment(R.layout.fragment_order) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val etNama = view.findViewById<EditText>(R.id.etNamaLengkap)
        val etAlamat = view.findViewById<EditText>(R.id.etAlamat)
        val etPatokan = view.findViewById<EditText>(R.id.etPatokan)

        etNama.setText(UserPrefs.getNama(requireContext()))

        view.findViewById<Button>(R.id.btnOrder).setOnClickListener {
            if (etNama.text.isBlank() || etAlamat.text.isBlank() || etPatokan.text.isBlank()) {
                Toast.makeText(requireContext(), "Lengkapi semua data pengiriman", Toast.LENGTH_SHORT).show()
            } else {
                startActivity(Intent(requireContext(), ConfirmationActivity::class.java))
            }
        }
    }
}