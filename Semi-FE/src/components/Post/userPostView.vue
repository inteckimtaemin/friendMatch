<template>
  <div class="container">
    <div class="row">
      <div class="row row-cols-1 row-cols-md-2 g-4">
        <div class="col">
          <div class="card">
            <img src="https://i.imgur.com/oIlJHTO.png" class="card-img-top" alt="...">
            <div class="card-body">
              <h5 class="card-title">제목 1</h5>
              <p class="card-text">설명 1</p>
              <div class="btn-group btn-group-sm" role="group" aria-label="...">
                <button type="button" class="btn btn-outline-primary">더보기</button>
              </div>
            </div>
          </div>
        </div>
        <div class="col">
          <div class="card">
            <img src="https://i.imgur.com/oIlJHTO.png" class="card-img-top" alt="...">
            <div class="card-body">
              <h5 class="card-title">제목 1</h5>
              <p class="card-text">설명 1</p>
              <div class="btn-group btn-group-sm" role="group" aria-label="...">
                <button type="button" class="btn btn-outline-primary">더보기</button>
              </div>
            </div>
          </div>
        </div>
        <div class="col">
          <div class="card">
            <img src="https://i.imgur.com/oIlJHTO.png" class="card-img-top" alt="...">
            <div class="card-body">
              <h5 class="card-title">제목 1</h5>
              <p class="card-text">설명 1</p>
              <div class="btn-group btn-group-sm" role="group" aria-label="...">
                <button type="button" class="btn btn-outline-primary">더보기</button>
              </div>
            </div>
          </div>
        </div>
        <div class="col">
          <div class="card">
            <img src="https://i.imgur.com/oIlJHTO.png" class="card-img-top" alt="...">
            <div class="card-body">
              <h5 class="card-title">제목 1</h5>
              <p class="card-text">설명 1</p>
              <div class="btn-group btn-group-sm" role="group" aria-label="...">
                <button type="button" class="btn btn-outline-primary">더보기</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <br />
    <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
      <div class="btn-group me-2" role="group" aria-label="First group">
        <button type="button" class="btn btn-primary" onclick="goToPage">1</button>
        <button type="button" class="btn btn-primary">2</button>
        <button type="button" class="btn btn-primary">3</button>
        <button type="button" class="btn btn-primary">4</button>
        <button type="button" class="btn btn-primary">5</button>
        <button type="button" class="btn btn-primary">6</button>
        <button type="button" class="btn btn-primary">7</button>
        <button type="button" class="btn btn-primary">8</button>
      </div>
    </div>
  </div>
</template>
<style scoped>


  /* https: //i.imgur.com/oIlJHTO.png */
  p {
    margin: 20px 0px;
  }

  .btn-toolbar {
    align-items: center;
    flex-direction: column !important;
  }

  .btn-toolbar > btn-group me-2 {
    margin: 20px 0px;
  }
</style>
<script>
  export default {}
</script>