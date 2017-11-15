// $(document).ready(function() {
// window.onload(function () {
    Dropzone.options.myAwesomeDropzone = {
        autoProcessQueue: false,
        uploadMultiple: true,
        parallelUploads: 100,
        maxFiles: 100,
        maxFileSize: 1,
        paramName: "files",
        method: "post",
        addRemoveLinks: true,
        // Dropzone settings
        init: function() {
            var myDropzone = this;
            var uploading = null;
            console.log("init func");
            this.element.querySelector("button[type=submit]").addEventListener("click", function(e) {
                e.preventDefault();
                e.stopPropagation();
                myDropzone.processQueue();
                //                    uploading = layer.load(0, {time: 10 * 1000});
            });
            this.on("sendingmultiple", function() {
                console.log("sendingmultiple");
                uploading = layer.load(0, {
                    shade: [0.8, 'white']
                });
            });
            this.on("successmultiple", function(files, response) {
                layer.close(uploading);

                var index = layer.open({
                    type: 2,
                    title: '服务器处理数据结果',
                    content: '/UploadFile/displayUploadInfo',
                    area: ['90%', '90%'],
                    maxmin: true,
                    closeBtn: 1
                });
                layer.full(index);

                console.log("successmultiple");
            });
            this.on("errormultiple", function(files, response) {
                layer.close(uploading);
                $('.dz-error-message').html("<span data-dz-errormessage='" + "'>上传失败</span>");
                console.log("errormultiple");
            });
        }

    }
// });


// });