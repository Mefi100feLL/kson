package dev.afanasev.kson.benchmark

import dev.afanasev.kson.generated.KsonTypeAdapterFactory
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.openjdk.jmh.annotations.Level
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.Setup
import org.openjdk.jmh.annotations.State

@State(Scope.Benchmark)
open class GsonState {

    lateinit var gson: Gson

    @Setup(Level.Trial)
    fun setUp() {
        gson = GsonBuilder().create()
    }
}

@State(Scope.Benchmark)
open class GsonWithKsonState {

    lateinit var gson: Gson

    @Setup(Level.Trial)
    fun setUp() {
        gson = GsonBuilder()
                .registerTypeAdapterFactory(KsonTypeAdapterFactory())
                .create()
    }
}

@State(Scope.Benchmark)
open class JsonState {

    lateinit var json: String

    @Setup(Level.Trial)
    fun setUp() {
        json = javaClass.getResource("/data.json").readText()
    }
}
