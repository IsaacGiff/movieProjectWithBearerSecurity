$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/rest/2"
    }).then(function(data) {
        $('.movie-id').append(data.id);
        $('.movie-title').append(data.title);
    });
});
