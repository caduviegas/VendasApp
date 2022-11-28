package com.innaval.vendasapp.domain.state

sealed class State<T>() {
    class Sucesso<T>(val data: T) : State<T>()
    class Carregando<T>: State<T>()
    class Erro<T>: State<T>()
}
