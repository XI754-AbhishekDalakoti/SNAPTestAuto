exports.config = {
    multiCapabilities: [{
        browserName: 'chrome'
    },
    ],

    framework: 'jasmine2',

    specs: ['src/test/test_spec/login_spec.js'],

    jasmineNodeOpts: {
        defaultTimeoutInterval: 2500000
    },

    onPrepare: function () {
        browser.driver.manage().timeouts().implicitlyWait(10000);
        var jasmineReporters = require('jasmine-reporters');
        jasmine.getEnv().addReporter(new jasmineReporters.JUnitXmlReporter({
            consolidateAll: true,
            savePath: 'testresults',
            filePrefix: 'xmloutput'
        }));

        var AllureReporter = require('jasmine-allure-reporter');
        jasmine.getEnv().addReporter(new AllureReporter({
            allureReport: {
                resultsDir: 'allure-results'
            }
        }));
        jasmine.getEnv().afterEach(function (done) {
            browser.takeScreenshot().then(function (png) {
                allure.createAttachment('Screenshot', function () {
                    return new Buffer(png, 'base64')
                }, 'image/png')();
                done();
            })
        });

    }
}