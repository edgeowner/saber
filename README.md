# saber
SSM基础框架
### 本项目Demo适用于**分布式**独立开发基础框架，基于Pigeon框架而搭建的部分聚合分块工程
### 项目结构如下：
        - |saber-demo-project 
          |  |-------------------------------------------------|
          |  |   saber-demo-project-api(暂无，未聚合Pigeon框架)   |
          |  |-------------------------------------------------|
          |-----| saber-demo-project-biz（逻辑业务和DAO层）
          |         |--- src
          |            |---- main
          |               |----- java
          |               |----- resources
          |            |---- test
          |         |--- pom
          |         
          |-----| saber-demo-project-job（定时任务层）
          |         |--- src
          |            |---- main
          |               |----- java
          |               |----- resources
          |               |----- webapp
          |            |---- test
          |         |--- pom
          |         
          |-----| saber-demo-project-web（控制器层）
          |         |--- src
          |            |---- main
          |               |----- java
          |               |----- resources
          |               |----- webapp
          |         |--- pom
          |
          |----- pom
