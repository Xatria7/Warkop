package lat.pam.warkop

import android.content.Context

object UserPrefs {
    private const val FILE = "kopi_prefs"

    private fun prefs(c: Context) = c.getSharedPreferences(FILE, Context.MODE_PRIVATE)

    fun register(c: Context, nama: String, username: String, password: String) {
        prefs(c).edit()
            .putString("nama", nama)
            .putString("username", username)
            .putString("password", password)
            .apply()
    }

    fun login(c: Context, username: String, password: String): Boolean {
        val p = prefs(c)
        return p.getString("username", null) == username &&
                p.getString("password", null) == password
    }

    fun getNama(c: Context): String = prefs(c).getString("nama", "") ?: ""

    fun setNama(c: Context, nama: String) {
        prefs(c).edit().putString("nama", nama).apply()
    }
}