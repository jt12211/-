const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootfuca0297/",
            name: "springbootfuca0297",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootfuca0297/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "智慧社区养老服务平台"
        } 
    }
}
export default base
