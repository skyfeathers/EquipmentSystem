const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootu6123/",
            name: "springbootu6123",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootu6123/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "智农设备管理系统"
        } 
    }
}
export default base
