package com.example.core.di

import androidx.annotation.MainThread
import androidx.annotation.VisibleForTesting

open class ComponentHolder<Component : Any> {

    @Volatile
    private var component: Component? = null
    private var componentProvider: () -> Component =
        { error("component provider cannot be found") }
    private var allowOverride: Boolean = true

    fun get(): Component {
        return component ?: synchronized(this) {
            component ?: componentProvider().also { set(it) }
        }
    }

    @VisibleForTesting
    fun set(component: Component) {
        this.component = component
    }

    @MainThread
    fun set(allowOverride: Boolean = true, provider: () -> Component) {
        if (this.allowOverride.not()) {
            return
        }
        this.allowOverride = allowOverride
        componentProvider = provider
    }
}