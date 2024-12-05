<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Add Post</title>
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow-sm">
        <div class="card-header bg-primary text-white">
            <h2 class="text-center">Add New Post</h2>
        </div>
        <div class="card-body">
            <form action="/post/add" method="post" enctype="multipart/form-data">
                <div class="mb-3">
                    <label for="title" class="form-label">Post Title</label>
                    <input type="text" class="form-control" id="title" name="title" placeholder="Enter title" required>
                </div>

                <div class="mb-3">
                    <label for="cover" class="form-label">Upload Cover Image</label>
                    <input type="file" class="form-control" id="cover" name="cover" accept="image/*" required>
                </div>

                <div class="mb-3">
                    <label for="audio" class="form-label">Upload Audio</label>
                    <input type="file" class="form-control" id="audio" name="audio" accept="audio/*">
                </div>

                <div class="mb-3">
                    <label for="video" class="form-label">Upload Video</label>
                    <input type="file" class="form-control" id="video" name="video" accept="video/*">
                </div>

                <div class="d-grid">
                    <button type="submit" class="btn btn-success btn-lg">Submit</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-wHnhVV8k6+33QaKpF6BlD9xPL4r+SLefP4Iw2SP6L5/jAdME8XwR1t1RHy6b6+h6" crossorigin="anonymous"></script>
</body>
</html>
