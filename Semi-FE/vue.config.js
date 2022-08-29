const { defineConfig } = require('@vue/cli-service')
// const path = require('path')
module.exports = defineConfig({
    pluginOptions: {
      quasar: {
        importStrategy: 'kebab',
        rtlSupport: true,
      },
        transpileDependencies: [
            'quasar'
        ]
    },
    css: {
        loaderOptions: {
            sass: {
                additionalData: `
                    @import "@/assets/scss/_reset.scss";
                    @import "@/assets/scss/_variables.scss";
                    @import "@/assets/scss/_breakpoints.scss";
                    @import "@/assets/scss/_mixins.scss";
                `
            }
        }
    },
    outputDir : "../Semi-BE/src/main/resources/static",
    devServer : {
        proxy: {
            '/api' : {
                target: 'http://localhost:8081',
                changeOrigin: true // cross origin 허용
            }
        }
    },
});
