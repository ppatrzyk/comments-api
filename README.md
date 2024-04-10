# comments-api

Simple REST API that enables storing comments for any static site.

## Endpoints

| Endpoint | Method | Request params | Body params | Description |
| --- | --- | --- | --- | --- |
| /api/comments | GET | host, path | | List comments at given host and path |
| /api/comments | POST | | host, path, author, comment | Add new comment |
| /api/comments | DELETE | id | | Delete comment |
| /api/votes | POST | commentId, score | | Vote on given comment |

## Setup

1. Run the service and note your `COMMENTS_API_ENDPOINT`

TODO docker instructions

2. Add the following under your `<head>`:

```
<script src="<COMMENTS_API_ENDPOINT>/comments-api.js"></script>
```

3. Add the following within your `<body>` (of course, you can adjust [<template>](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/template) as needed):

```
    <!-- place this where the comments should appear -->
    <div id="comments-api-comments"></div>
    
    <template id="comments-api-new-comment">
        <p><input type="text" id="comments-api-new-comment-author" required minlength="1" size="10" placeholder="Your name..." /></p>
        <p><textarea name="" id="comments-api-new-comment-text" cols="30" rows="5" placeholder="Your comment..."></textarea></p>
        <p><button id="comments-api-new-comment-button" onclick="saveComment(this)">Comment</button></p>
    </template>
    <template id="comments-api-comment">
        <p class="comments-api-comment-author"></p>
        <p class="comments-api-comment-ts"></p>
        <p class="comments-api-comment-content"></p>
        <p class="comments-api-comment-score"></p>
        <p><button class="comments-api-comment-vote" data-comment-id="" onclick="vote(this, -1)">Downvote</button></p>
        <p><button class="comments-api-comment-vote" data-comment-id="" onclick="vote(this, 1)">Upvote</button></p>
    </template>
    <script>
        loadComments("<COMMENTS_API_ENDPOINT>", "comments-api-comments")
    </script>
```

## Not yet available

- reply to comment option
- access control
- tests
