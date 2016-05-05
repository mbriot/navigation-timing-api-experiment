function getPerfStats() {
    var timing = window.performance.timing;
    return {
        pathname : window.location.pathname,
        dnsLookup: timing.domainLookupEnd - timing.domainLookupStart,
        handshake: timing.connectEnd - timing.connectStart,
        ttfb: timing.responseStart - timing.connectEnd,
        downloadPage: timing.responseEnd - timing.responseStart,
        renderingProcess: timing.loadEventStart - timing.responseEnd
    };
}

window.onload = function() {
    if (window.performance && window.performance.timing) {
        var ntStats = getPerfStats();
        $.ajax({
            url : '/metrics',
            type : 'POST',
            data : 'data=' + JSON.stringify(ntStats)
        });
    }
};
