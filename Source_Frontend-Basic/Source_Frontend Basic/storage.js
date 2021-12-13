var storage = {
    saveRemember(isRememberMe) {
        localStorage.setItem("IS_REMEMBER_ME", isRememberMe);
    },

    getRemember() {
        var rememberStr = localStorage.getItem("IS_REMEMBER_ME")
        if (rememberStr == null) {
            return true;
        }
        return JSON.parse(rememberStr.toLowerCase());
    },

    setItem(key, value) {
        if (this.getRemember()) {
            localStorage.setItem(key, value);
        } else {
            sessionStorage.setItem(key, value);
        }
    },

    getItem(key) {
        if (this.getRemember()) {
            return localStorage.getItem(key);
        } else {
            return sessionStorage.getItem(key);
        }
    },

    removeItem(key) {
        if (this.getRemember()) {
            return localStorage.removeItem(key);
        } else {
            return sessionStorage.removeItem(key);
        }
    }
};