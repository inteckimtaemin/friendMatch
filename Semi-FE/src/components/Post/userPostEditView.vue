<template>
    <div class="container" role="main">
        <br />
        <h2>게시글 수정</h2>
            <div class="mb-3">
                <label for="title">제목</label>
                <input type="text" class="form-control" name="title" id="title" placeholder="제목을 입력해 주세요">
            </div>
            <div class="mb-3">
                <label for="content">내용</label>
                <textarea class="form-control" rows="5" name="content" id="content"
                    placeholder="내용을 입력해 주세요"></textarea>
            </div>
            <div class="mb-3">
                <label for="formFileMultiple" class="form-label">사진 선택</label>
                <input class="form-control" type="file" id="formFileMultiple" multiple>
            </div>
            <div class="mb-3">
                <label for="tag">태그</label>
                <input type="text" class="form-control" name="tag" id="tag" placeholder="태그를 입력해 주세요">
            </div>
        <div>
            <button type="button" class="btn btn-sm btn-primary" id="btnSave">저장</button>
            <button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button>
        </div>
    </div>
</template>

<style scoped>

body {
    padding-top: 70px;
    padding-bottom: 30px;
}
</style>
<script>
export default {
    methods: {
        btnSave(){
            alert("게시글 저장 완료");
            location.href("/userPost");
        },
        btnList(){
            location.href("/userPost");
        }
    }
};
</script>