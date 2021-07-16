var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "2",
        "ok": "0",
        "ko": "2"
    },
    "minResponseTime": {
        "total": "235",
        "ok": "-",
        "ko": "235"
    },
    "maxResponseTime": {
        "total": "947",
        "ok": "-",
        "ko": "947"
    },
    "meanResponseTime": {
        "total": "591",
        "ok": "-",
        "ko": "591"
    },
    "standardDeviation": {
        "total": "356",
        "ok": "-",
        "ko": "356"
    },
    "percentiles1": {
        "total": "591",
        "ok": "-",
        "ko": "591"
    },
    "percentiles2": {
        "total": "769",
        "ok": "-",
        "ko": "769"
    },
    "percentiles3": {
        "total": "911",
        "ok": "-",
        "ko": "911"
    },
    "percentiles4": {
        "total": "940",
        "ok": "-",
        "ko": "940"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 2,
    "percentage": 100
},
    "meanNumberOfRequestsPerSecond": {
        "total": "1",
        "ok": "-",
        "ko": "1"
    }
},
contents: {
"req_open-main-page-0676f": {
        type: "REQUEST",
        name: "Open main page",
path: "Open main page",
pathFormatted: "req_open-main-page-0676f",
stats: {
    "name": "Open main page",
    "numberOfRequests": {
        "total": "1",
        "ok": "0",
        "ko": "1"
    },
    "minResponseTime": {
        "total": "947",
        "ok": "-",
        "ko": "947"
    },
    "maxResponseTime": {
        "total": "947",
        "ok": "-",
        "ko": "947"
    },
    "meanResponseTime": {
        "total": "947",
        "ok": "-",
        "ko": "947"
    },
    "standardDeviation": {
        "total": "0",
        "ok": "-",
        "ko": "0"
    },
    "percentiles1": {
        "total": "947",
        "ok": "-",
        "ko": "947"
    },
    "percentiles2": {
        "total": "947",
        "ok": "-",
        "ko": "947"
    },
    "percentiles3": {
        "total": "947",
        "ok": "-",
        "ko": "947"
    },
    "percentiles4": {
        "total": "947",
        "ok": "-",
        "ko": "947"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 1,
    "percentage": 100
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.5",
        "ok": "-",
        "ko": "0.5"
    }
}
    },"req_start-quiz-5c786": {
        type: "REQUEST",
        name: "Start quiz",
path: "Start quiz",
pathFormatted: "req_start-quiz-5c786",
stats: {
    "name": "Start quiz",
    "numberOfRequests": {
        "total": "1",
        "ok": "0",
        "ko": "1"
    },
    "minResponseTime": {
        "total": "235",
        "ok": "-",
        "ko": "235"
    },
    "maxResponseTime": {
        "total": "235",
        "ok": "-",
        "ko": "235"
    },
    "meanResponseTime": {
        "total": "235",
        "ok": "-",
        "ko": "235"
    },
    "standardDeviation": {
        "total": "0",
        "ok": "-",
        "ko": "0"
    },
    "percentiles1": {
        "total": "235",
        "ok": "-",
        "ko": "235"
    },
    "percentiles2": {
        "total": "235",
        "ok": "-",
        "ko": "235"
    },
    "percentiles3": {
        "total": "235",
        "ok": "-",
        "ko": "235"
    },
    "percentiles4": {
        "total": "235",
        "ok": "-",
        "ko": "235"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 1,
    "percentage": 100
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.5",
        "ok": "-",
        "ko": "0.5"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
