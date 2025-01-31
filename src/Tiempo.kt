class Tiempo(var hora: Int, var minuto: Int, var segundo: Int) {

    init {
        if (hora !in 0..23) throw IllegalArgumentException("La hora debe estar entre 0 y 23")
        if (minuto !in 0..59) throw IllegalArgumentException("El minuto debe estar entre 0 y 59")
        if (segundo !in 0..59) throw IllegalArgumentException("El segundo debe estar entre 0 y 59")
    }

    override fun toString(): String {
        return "%02dh %02dm %02ds".format(hora, minuto, segundo)
    }

    fun incrementar(t: Tiempo): Boolean {
        val totalSegundos = (this.hora * 3600 + this.minuto * 60 + this.segundo) + (t.hora * 3600 + t.minuto * 60 + t.segundo)
        if (totalSegundos >= 86400) return false
        this.hora = (totalSegundos / 3600) % 24
        this.minuto = (totalSegundos % 3600) / 60
        this.segundo = totalSegundos % 60
        return true
    }

    fun decrementar(t: Tiempo): Boolean {
        val totalSegundos = (this.hora * 3600 + this.minuto * 60 + this.segundo) - (t.hora * 3600 + t.minuto * 60 + t.segundo)
        if (totalSegundos < 0) return false
        this.hora = (totalSegundos / 3600) % 24
        this.minuto = (totalSegundos % 3600) / 60
        this.segundo = totalSegundos % 60
        return true
    }

    fun comparar(t: Tiempo): Int {
        val thisTotalSegundos = this.hora * 3600 + this.minuto * 60 + this.segundo
        val tTotalSegundos = t.hora * 3600 + t.minuto * 60 + t.segundo
        return when {
            thisTotalSegundos < tTotalSegundos -> -1
            thisTotalSegundos > tTotalSegundos -> 1
            else -> 0
        }
    }

    fun copiar(): Tiempo {
        return Tiempo(this.hora, this.minuto, this.segundo)
    }

    fun copiar(t: Tiempo): Tiempo {
        this.hora = t.hora
        this.minuto = t.minuto
        this.segundo = t.segundo
        return this
    }

    fun sumar(t: Tiempo): Tiempo? {
        val totalSegundos = (this.hora * 3600 + this.minuto * 60 + this.segundo) + (t.hora * 3600 + t.minuto * 60 + t.segundo)
        if (totalSegundos >= 86400) return null
        return Tiempo((totalSegundos / 3600) % 24, (totalSegundos % 3600) / 60, totalSegundos % 60)
    }

    fun restar(t: Tiempo): Tiempo? {
        val totalSegundos = (this.hora * 3600 + this.minuto * 60 + this.segundo) - (t.hora * 3600 + t.minuto * 60 + t.segundo)
        if (totalSegundos < 0) return null
        return Tiempo((totalSegundos / 3600) % 24, (totalSegundos % 3600) / 60, totalSegundos % 60)
    }

    fun esMayorQue(t: Tiempo): Boolean {
        val thisTotalSegundos = this.hora * 3600 + this.minuto * 60 + this.segundo
        val tTotalSegundos = t.hora * 3600 + t.minuto * 60 + t.segundo
        return thisTotalSegundos > tTotalSegundos
    }

    fun esMenorQue(t: Tiempo): Boolean {
        val thisTotalSegundos = this.hora * 3600 + this.minuto * 60 + this.segundo
        val tTotalSegundos = t.hora * 3600 + t.minuto * 60 + t.segundo
        return thisTotalSegundos < tTotalSegundos
    }
}