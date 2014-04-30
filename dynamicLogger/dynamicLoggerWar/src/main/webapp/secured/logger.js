var myFunction = {
	
	getLoggers: function() {
		$.getJSON("./dynamicLogger", function(data) {
			myFunction.processLoggers(data);
		});
		
	},

	processLoggers: function(data) {
		var html = '<table border="1"><tr><td><b>Logger</b></td><td><b>Current Level</b></td><td><b>Update Level to:</b></td></tr>';
		$.each(data.activeLoggers, function(index, activeLogger) {
			html += '<tr>';
			html += '<td>' + activeLogger.name + '</td>' + '<td>' + activeLogger.currentLevel + '</td>';
			html += '<td>';
			$.each(activeLogger.availableLevel, function(index, alevel) {
				if (alevel.current) {
					html +=  alevel.level;
				} else {
					html += '<a href="./dynamicLogger/update/' + activeLogger.name + '/' + alevel.level + '">' + alevel.level + '</a>';
				}
				html += '&nbsp';
			});
			html += '</td>';
			html += '</tr>';
		});
		html += '</table>';
		$('body').append(html);
		myFunction.postEvent();
	},

	postEvent: function() {
		$("a").click(function(event) {
			event.preventDefault();
			$.post(event.delegateTarget.href);
			location.reload(true);
		});
		
	}
};

$(document).ready( myFunction.getLoggers());