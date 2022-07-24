module.exports = {
  transpileDependencies: ["vuetify"],
  devServer: {
    host: "localhost", // frontend hostname or ip
    allowedHosts: "all",
    port: 8080, // frontend port
    https: false, // no ssl
    proxy: {
      "/api/": {
        // proxy everything from frontend http://localhost:8080/api/** to backend at http://localhost:8081/api/**
        // that is why all api on backend should begin with /api
        target: "http://localhost:8081",
      },
    },
    headers: {
      // typical header setting
      "Access-Control-Allow-Origin": "*",
      "Access-Control-Allow-Methods": "GET, POST, PUT, DELETE, PATCH, OPTIONS",
      "Access-Control-Allow-Headers":
        "X-Requested-With, content-type, Authorization",
    },
  },
};
