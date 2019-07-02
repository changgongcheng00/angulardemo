import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  constructor(public http: HttpClient) { }

  public isShow = 0;
  public httpOptions = { headers: new HttpHeaders({'Content-Type': 'application/json;charset=UTF-8'}) };
  public listUrl = 'http://localhost:8080/angular/getUser';
  public detailUrl = 'http://localhost:8080/angular/getUserDetail?id=';
  public souUrl = 'http://localhost:8080/angular/addUser';
  public removeUrl = 'http://localhost:8080/angular/removeUser?id=';
  public arr:any = new Array();
  // 查询信息
  getData() {
    this.http.get(this.listUrl).subscribe((e) => {
      this.arr = e;
    });
  }
  getDetail(id) {
    this.http.get(this.detailUrl + id).subscribe((e) => {
      const es: any = e;
      (<HTMLInputElement> document.getElementById('id')).value = es.id;
      (<HTMLInputElement> document.getElementById('username')).value = es.username;
      (<HTMLInputElement> document.getElementById('password')).value = es.password;
      (<HTMLInputElement> document.getElementById('tel')).value = es.tel;
      (<HTMLInputElement> document.getElementById('age')).value = es.age;
    });
  }
  // 打开编辑窗口
  addData() {
    this.isShow = 1;
    document.getElementById('formdata').innerText = '用户新增页面';
    this.souUrl = 'http://localhost:8080/angular/addUserCheck';
  }
  editData(id) {
    this.isShow = 1;
    document.getElementById('formdata').innerText = '用户编辑页面';
    this.souUrl = 'http://localhost:8080/angular/updateUser';
    this.getDetail(id);
  }
  // 删除
  remove(id) {
    this.http.delete(this.removeUrl + id).subscribe((e) => {
      const data: any = e;
      if (data.code === 0) {
        this.ngOnInit();
      } else {
        alert(data.msg);
      }
    });
  }
  // 调用保存数据的远程方法
  setData( data) {
    this.http.post(this.souUrl, data , this.httpOptions).subscribe(e => {
      const datas: any = e;
      if (datas.code === 0) {
        this.ngOnInit();
      } else if ( datas.code === 3000) {
        const flag = confirm('已经存在相似的文本如下,是否仍然提交：' + datas.data );
        if (flag === true ) {
          this.souUrl = 'http://localhost:8080/angular/addUser';
          this.submit();
        }
      } else {
        alert(datas.msg);
      }
    });
  }
// 保存
  public submit() {
    const id = (<HTMLInputElement> document.getElementById('id')).value;
    const username = (<HTMLInputElement> document.getElementById('username')).value;
    const password = (<HTMLInputElement> document.getElementById('password')).value;
    const tel = (<HTMLInputElement> document.getElementById('tel')).value;
    const age = (<HTMLInputElement> document.getElementById('age')).value;
    if (username === '' || password === '' ) {
      alert('用户名密码不能为空');
      return;
    }
    const user = {
      'id': id, 'username' : username,'password': password,'tel': tel,'age': age
    };
    this.setData(user);
    this.isShow = 0;
  }
// 页面组件初始化方法
  ngOnInit() {
    this.getData();
  }
}
