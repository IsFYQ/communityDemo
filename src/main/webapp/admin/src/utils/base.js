const base = {
    get() {
        return {
            url : "http://localhost:8080/ssmm00v5/",
            name: "ssmm00v5",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssmm00v5/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于J2EE的校内社团学习交流系统"
        } 
    }
}
export default base
