const base = {
    get() {
        return {
            url : "http://localhost:8092/eps/",
            name: "eps",
            // 退出到首页链接
            indexUrl: 'http://localhost:8092/eps/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "智农设备管理系统"
        } 
    }
}
export default base
