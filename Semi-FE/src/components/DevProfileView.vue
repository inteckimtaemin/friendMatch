<template>
  <section style="background-color: #9de2ff;">
    <div class="container py-5 h-100">
      <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-8">
          <div class="card" style="border-radius: 15px;">
            <div class="card-body p-4">
              <div class="d-flex text-black">
                <div class="flex-shrink-0">
                  <img src=""
                       alt="Profile img" class="img-fluid"
                       style="width: 180px; border-radius: 10px;" />
                </div>
                <div class="flex-grow-1 ms-3">
                  <h5 class="mb-1">전종욱</h5>
                  <p class="mb-2 pb-1" style="color: #2b2a2a;">
                    FrontEnd Developer
                  </p>
                  <div class="d-flex justify-content-start rounded-3 p-2 mb-2"
                       style="background-color: #efefef;">
                    <div>
                      <p class="small text-muted mb-1">
                        게시글
                      </p>
                      <p class="mb-0">{{posting}}개</p>
                    </div>
                    <div class="px-3">
                      <p class="small text-muted mb-1">
                        팔로워
                      </p>
                      <p class="mb-0">{{follower}}명</p>
                    </div>
                    <div>
                      <p class="small text-muted mb-1">
                        팔로잉
                      </p>
                      <p class="mb-0">{{following}}명</p>
                    </div>
                  </div>
                  <div class="d-flex pt-1">
                    <button type="button" class="btn btn-outline-primary me-1 flex-grow-1">
                      메시지 보내기
                    </button>
                    <button type="button" class="btn btn-primary flex-grow-1">
                      팔로우
                    </button>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
export default {
  name: "DevProfileView",
  data : function() {
    return {
      posting : 1,
      follower : 1,
      following : 1,
    };
  },
}
</script>

<style scoped>

</style>