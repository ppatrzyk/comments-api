function loadComments(apiURL, elementId) {
    window.apiURL = apiURL;
    window.host = location.hostname;
    window.path = `/${location.pathname.replace(/(\/+$|^\/+)/g, "")}`;
    var newCommentTemplate = document.getElementById("comments-api-new-comment");
    var commentTemplate = document.getElementById("comments-api-comment");
    var commentsDiv = document.getElementById(elementId);
    commentsDiv.replaceChildren()
    var getCommentURL = `${apiURL}/api/comments?${new URLSearchParams({host: host, path: path})}`
    fetch(getCommentURL)
    .then(response => {
        if (!response.ok) {
            console.error("Failed to get comments " + response.status);
        }
        return response.json();
    })
    .then(comments => {
        comments.forEach(el => {
            var comment = commentTemplate.content.cloneNode(true);
            comment.querySelector(".comments-api-comment-author").textContent = el.author;
            comment.querySelector(".comments-api-comment-ts").textContent = el.ts;
            comment.querySelector(".comments-api-comment-content").textContent = el.content;
            comment.querySelector(".comments-api-comment-score").textContent = `Score: ${el.score} | Upvotes: ${el.upvotes} | Downvotes: ${el.downvotes}`;
            comment.querySelectorAll(".comments-api-comment-vote").forEach(button => {button.setAttribute("data-comment-id", el.id)});
            commentsDiv.appendChild(comment);
        });
    })
    .catch(function (err) {console.error(err)})
    
    commentsDiv.appendChild(newCommentTemplate.content.cloneNode(true));
}

function saveComment(button) {
    var author = document.getElementById("comments-api-new-comment-author").value;
    var content = document.getElementById("comments-api-new-comment-text").value;
    var saveCommentURL = `${apiURL}/api/comments`;
    fetch(saveCommentURL, {
        method: "POST",
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({host: host, path: path, author: author, content: content})
    })
    .then(response => {
        if (!response.ok) {
            console.error("Failed to save comment " + response.status);
        }
        return response.json();
    })
    .then(_comment => {window.location.reload(false);})
    .catch(function (err) {console.error(err)})
}

function vote(button, score) {
    console.log(button.getAttribute("data-comment-id"))
    var saveVoteURL = `${apiURL}/api/votes`;
    fetch(saveVoteURL, {
        method: "POST",
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({commentId: button.getAttribute("data-comment-id"), score: score})
    })
    .then(response => {
        if (!response.ok) {
            console.error("Failed to vote " + response.status);
        }
        return response.json();
    })
    .then(_comment => {window.location.reload(false);})
    .catch(function (err) {console.error(err)})
}