fun main() {

    println("Introduce la hora:")
    val hora = readLine()?.toIntOrNull() ?: return println("Hora no válida")
    println("Introduce el minuto:")
    val minuto = readLine()?.toIntOrNull() ?: return println("Minuto no válido")
    println("Introduce el segundo:")
    val segundo = readLine()?.toIntOrNull() ?: return println("Segundo no válido")

    val tiempo = try {
        Tiempo(hora, minuto, segundo)
    } catch (e: IllegalArgumentException) {
        println(e.message)
        return
    }

    println("Tiempo creado: $tiempo")

    println("Introduce la hora a incrementar:")
    val horaIncrementar = readLine()?.toIntOrNull() ?: return println("Hora no válida")
    println("Introduce el minuto a incrementar:")
    val minutoIncrementar = readLine()?.toIntOrNull() ?: return println("Minuto no válido")
    println("Introduce el segundo a incrementar:")
    val segundoIncrementar = readLine()?.toIntOrNull() ?: return println("Segundo no válido")

    val tiempoIncrementar = Tiempo(horaIncrementar, minutoIncrementar, segundoIncrementar)

    val incrementoExitoso = tiempo.incrementar(tiempoIncrementar)
    if (incrementoExitoso) {
        println("Tiempo después de incrementar: $tiempo")
    } else {
        println("Error: El incremento supera las 23:59:59")
    }

    println("Introduce la hora a decrementar:")
    val horaDecrementar = readLine()?.toIntOrNull() ?: return println("Hora no válida")
    println("Introduce el minuto a decrementar:")
    val minutoDecrementar = readLine()?.toIntOrNull() ?: return println("Minuto no válido")
    println("Introduce el segundo a decrementar:")
    val segundoDecrementar = readLine()?.toIntOrNull() ?: return println("Segundo no válido")

    val tiempoDecrementar = Tiempo(horaDecrementar, minutoDecrementar, segundoDecrementar)

    val decrementoExitoso = tiempo.decrementar(tiempoDecrementar)
    if (decrementoExitoso) {
        println("Tiempo después de decrementar: $tiempo")
    } else {
        println("Error: El decremento supera las 00:00:00")
    }

    println("Introduce la hora para comparar:")
    val horaComparar = readLine()?.toIntOrNull() ?: return println("Hora no válida")
    println("Introduce el minuto para comparar:")
    val minutoComparar = readLine()?.toIntOrNull() ?: return println("Minuto no válido")
    println("Introduce el segundo para comparar:")
    val segundoComparar = readLine()?.toIntOrNull() ?: return println("Segundo no válido")

    val tiempoComparar = Tiempo(horaComparar, minutoComparar, segundoComparar)
    val comparacion = tiempo.comparar(tiempoComparar)
    println("Resultado de la comparación: $comparacion")

    println("Introduce la hora para copiar:")
    val horaCopiar = readLine()?.toIntOrNull() ?: return println("Hora no válida")
    println("Introduce el minuto para copiar:")
    val minutoCopiar = readLine()?.toIntOrNull() ?: return println("Minuto no válido")
    println("Introduce el segundo para copiar:")
    val segundoCopiar = readLine()?.toIntOrNull() ?: return println("Segundo no válido")

    val tiempoCopiar = Tiempo(horaCopiar, minutoCopiar, segundoCopiar)
    val tiempoCopiado = tiempo.copiar()
    println("Tiempo copiado: $tiempoCopiado")

    val nuevoTiempo = tiempo.copiar(tiempoCopiar)
    println("Tiempo copiado a otro objeto: $nuevoTiempo")

    println("Introduce la hora a sumar:")
    val horaSumar = readLine()?.toIntOrNull() ?: return println("Hora no válida")
    println("Introduce el minuto a sumar:")
    val minutoSumar = readLine()?.toIntOrNull() ?: return println("Minuto no válido")
    println("Introduce el segundo a sumar:")
    val segundoSumar = readLine()?.toIntOrNull() ?: return println("Segundo no válido")

    val tiempoSumar = Tiempo(horaSumar, minutoSumar, segundoSumar)
    val tiempoSumado = tiempo.sumar(tiempoSumar)
    if (tiempoSumado != null) {
        println("Tiempo después de sumar: $tiempoSumado")
    } else {
        println("Error: La suma supera las 23:59:59")
    }

    println("Introduce la hora a restar:")
    val horaRestar = readLine()?.toIntOrNull() ?: return println("Hora no válida")
    println("Introduce el minuto a restar:")
    val minutoRestar = readLine()?.toIntOrNull() ?: return println("Minuto no válido")
    println("Introduce el segundo a restar:")
    val segundoRestar = readLine()?.toIntOrNull() ?: return println("Segundo no válido")

    val tiempoRestar = Tiempo(horaRestar, minutoRestar, segundoRestar)
    val tiempoRestado = tiempo.restar(tiempoRestar)
    if (tiempoRestado != null) {
        println("Tiempo después de restar: $tiempoRestado")
    } else {
        println("Error: La resta supera las 00:00:00")
    }

    val esMayor = tiempo.esMayorQue(tiempoComparar)
    println("¿Es mayor que el tiempo comparado? $esMayor")

    val esMenor = tiempo.esMenorQue(tiempoComparar)
    println("¿Es menor que el tiempo comparado? $esMenor")
}