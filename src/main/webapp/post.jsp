<%@ page import="java.util.List" %>
<%@ page import="com.example.finish.entity.Post" %>
<%@ page import="com.example.finish.repo.PostRepo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Posts</title>
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h1 class="text-primary">Posts</h1>
        <a href="addpost.jsp" class="btn btn-success">Add New Post</a>
    </div>

    <%
        List<Post> posts = PostRepo.findAll();
        if (posts == null || posts.isEmpty()) {
    %>
    <div class="alert alert-warning text-center" role="alert">
        No posts available.
    </div>
    <%
    } else {
    %>
    <table class="table table-bordered table-hover">
        <thead class="table-dark">
        <tr>
            <th>Id</th>
            <th>Title</th>
            <th>Cover</th>
            <th>Audio</th>
            <th>Video</th>
        </tr>
        </thead>
        <tbody>
        <%
            for (Post post : posts) {
        %>
        <tr>
            <td><%= post.getId() %></td>
            <td><%= post.getTitle() %></td>
            <td>
                <img src="/file/get?id=<%= post.getCover() != null ? post.getCover().getId() : "#" %>"
                     alt="Image not found" height="70" width="70" class="img-thumbnail">
            </td>
            <td>
                <% if (post.getAudio() != null) { %>
                <audio controls>
                    <source src="/file/get?id=<%= post.getAudio().getId() %>" type="audio/mpeg">
                    <source src="/file/get?id=<%= post.getAudio().getId() %>" type="audio/ogg">
                    Your browser does not support the audio tag.
                </audio>
                <% } else { %>
                <span class="text-muted">No audio available</span>
                <% } %>
            </td>
            <td>
                <% if (post.getVideo() != null) { %>
                <video controls width="100" height="100">
                    <source src="/file/get?id=<%= post.getVideo().getId() %>" type="video/mp4">
                    Your browser does not support the video tag.
                </video>
                <% } else { %>
                <span class="text-muted">No video available</span>
                <% } %>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <% } %>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-wHnhVV8k6+33QaKpF6BlD9xPL4r+SLefP4Iw2SP6L5/jAdME8XwR1t1RHy6b6+h6" crossorigin="anonymous"></script>
</body>
</html>
