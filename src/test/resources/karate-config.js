function fn() {
    var config = { // base config JSON
        appId: 'my.app.id',
        baseUrl: 'http://localhost:8083/'
    };
    karate.configure('ssl', false);
    karate.configure('readTimeout', 5000);
    return config;
}