(function(t){function e(e){for(var r,o,s=e[0],u=e[1],l=e[2],d=0,m=[];d<s.length;d++)o=s[d],Object.prototype.hasOwnProperty.call(a,o)&&a[o]&&m.push(a[o][0]),a[o]=0;for(r in u)Object.prototype.hasOwnProperty.call(u,r)&&(t[r]=u[r]);c&&c(e);while(m.length)m.shift()();return n.push.apply(n,l||[]),i()}function i(){for(var t,e=0;e<n.length;e++){for(var i=n[e],r=!0,s=1;s<i.length;s++){var u=i[s];0!==a[u]&&(r=!1)}r&&(n.splice(e--,1),t=o(o.s=i[0]))}return t}var r={},a={app:0},n=[];function o(e){if(r[e])return r[e].exports;var i=r[e]={i:e,l:!1,exports:{}};return t[e].call(i.exports,i,i.exports,o),i.l=!0,i.exports}o.m=t,o.c=r,o.d=function(t,e,i){o.o(t,e)||Object.defineProperty(t,e,{enumerable:!0,get:i})},o.r=function(t){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(t,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(t,"__esModule",{value:!0})},o.t=function(t,e){if(1&e&&(t=o(t)),8&e)return t;if(4&e&&"object"===typeof t&&t&&t.__esModule)return t;var i=Object.create(null);if(o.r(i),Object.defineProperty(i,"default",{enumerable:!0,value:t}),2&e&&"string"!=typeof t)for(var r in t)o.d(i,r,function(e){return t[e]}.bind(null,r));return i},o.n=function(t){var e=t&&t.__esModule?function(){return t["default"]}:function(){return t};return o.d(e,"a",e),e},o.o=function(t,e){return Object.prototype.hasOwnProperty.call(t,e)},o.p="/";var s=window["webpackJsonp"]=window["webpackJsonp"]||[],u=s.push.bind(s);s.push=e,s=s.slice();for(var l=0;l<s.length;l++)e(s[l]);var c=u;n.push([0,"chunk-vendors"]),i()})({0:function(t,e,i){t.exports=i("56d7")},"0051":function(t,e,i){"use strict";var r=i("2d71"),a=i.n(r);e["default"]=a.a},"034f":function(t,e,i){"use strict";i("85ec")},"076e":function(t,e,i){"use strict";var r=i("2ae6"),a=i("0051"),n=i("2877"),o=i("6544"),s=i.n(o),u=i("553a"),l=Object(n["a"])(a["default"],r["a"],r["b"],!1,null,null,null);e["default"]=l.exports,s()(l,{VFooter:u["a"]})},"0cf6":function(t,e,i){"use strict";i("1b6b")},1732:function(t,e,i){"use strict";i("47a6")},"1b6b":function(t,e,i){},"2ae6":function(t,e,i){"use strict";i.d(e,"a",(function(){return r})),i.d(e,"b",(function(){return a}));var r=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("v-footer",{attrs:{height:"30",app:""}},[i("span",[t._v("© 2021 CS6310 -Group 98")])])},a=[]},"2d71":function(t,e){},"47a6":function(t,e,i){},"56d7":function(t,e,i){"use strict";i.r(e);i("e260"),i("e6cf"),i("cca6"),i("a79d");var r=i("2b0e"),a=i("1dce"),n=i.n(a),o=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("v-app",{attrs:{id:"inspire"}},[i("mynav"),i("router-view"),i("myfooter")],1)},s=[],u={name:"inspire",created:function(){this.$vuetify.theme.dark=!0}},l=u,c=(i("034f"),i("2877")),d=i("6544"),m=i.n(d),p=i("7496"),f=Object(c["a"])(l,o,s,!1,null,null,null),v=f.exports;m()(f,{VApp:p["a"]});var h=i("8c4f"),b=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("v-content",{attrs:{app:""}},[i("v-app-bar",{attrs:{app:""}},[i("v-spacer"),i("v-toolbar-title",[t._v("Streaming War Application")]),i("v-spacer")],1),i("div",{staticClass:"background"},[i("h1",[t._v("Welcome to our Streaming War Application")])])],1)},g=[],w={data:function(){return{drawer:null}}},_=w,x=(i("b943"),i("40dc")),y=i("a75b"),A=i("2fa4"),$=i("2a7f"),C=Object(c["a"])(_,b,g,!1,null,"55817d26",null),V=C.exports;m()(C,{VAppBar:x["a"],VContent:y["a"],VSpacer:A["a"],VToolbarTitle:$["a"]});var q=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("v-content",{attrs:{app:""}},[i("div",{attrs:{id:"dashboard"}},[i("h1",[t._v("Streaming War Dashboard")]),t.auth?t._e():i("p",[t._v("You should only get here if you're authenticated!")]),t.auth?i("v-card",{staticClass:"mx-auto",attrs:{"max-width":"1500",color:"white"}},[i("v-container",{attrs:{fluid:""}},[i("v-row",{attrs:{dense:""}},t._l(t.filterdList,(function(e){return i("v-col",{key:e.title,attrs:{cols:e.flex}},[i("v-card",[i("v-img",{staticClass:"white--text align-end",attrs:{src:e.src,gradient:"to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)",height:"200px"}},[i("v-card-title",{domProps:{textContent:t._s(e.title)}})],1),i("v-card-actions",[i("v-list",{attrs:{flat:""}},t._l(e.links,(function(e){return i("v-list-item",{key:e.text,attrs:{link:"",to:e.route}},[i("v-list-item-action",[i("v-icon",[t._v(t._s(e.icon))])],1),i("v-list-item-content",[i("v-list-item-title",[t._v(t._s(e.text))])],1)],1)})),1)],1)],1)],1)})),1)],1)],1):t._e()],1)])},P=[],O=i("5530"),S=(i("d81d"),i("4de4"),{data:function(){return{cards:[{title:"Group",src:"https://images.pexels.com/photos/853168/pexels-photo-853168.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=750&w=1260",flex:6,links:[{icon:"mdi-play-box-outline",text:"Display Group",route:"/",requireAdmin:!1},{icon:"mdi-pencil-plus",text:"Create Group",route:"/",requireAdmin:!0},{icon:"mdi-update",text:"Update group",route:"/",requireAdmin:!0},{icon:"mdi-database-lock-outline",text:"Watch History",route:"/",requireAdmin:!0}]},{title:"Offer",src:"https://ei.marketwatch.com/Multimedia/2020/05/21/Photos/ZQ/MW-IG985_Movies_20200521113911_ZQ.jpg?uuid=378c769c-9b79-11ea-bd9d-9c8e992d421e",flex:6,links:[{icon:"mdi-play-box-outline",text:"Display Offer",route:"/",requireAdmin:!1},{icon:"mdi-pencil-plus",text:"Create Offer",route:"/",requireAdmin:!0},{icon:"mdi-update",text:"Update Offer",route:"/",requireAdmin:!0},{icon:"mdi-delete",text:"Delete Offer",route:"/",requireAdmin:!0}]},{title:"Event",src:"https://i.insider.com/5f578371e6ff30001d4e76be?width=1136&format=jpeg",flex:4,links:[{icon:"mdi-play-box-outline",text:"Display Event",route:"/",requireAdmin:!1},{icon:"mdi-pencil-plus",text:"Create Event",route:"/",requireAdmin:!0},{icon:"mdi-update",text:"Update Event",route:"/",requireAdmin:!0}]},{title:"Service",src:"https://miro.medium.com/max/970/0*AB_I3rxxmNRsBL43.jpg",flex:4,links:[{icon:"mdi-play-box-outline",text:"Display Service",route:"/",requireAdmin:!1},{icon:"mdi-pencil-plus",text:"Create Service",route:"/",requireAdmin:!0},{icon:"mdi-update",text:"Update Service",route:"/",requireAdmin:!0}]},{title:"Studio",src:"https://www.reminetwork.com/wp-content/uploads/filmstudio.jpg",flex:4,links:[{icon:"mdi-play-box-outline",text:"Display Studio",route:"/",requireAdmin:!1},{icon:"mdi-pencil-plus",text:"Create Studio",route:"/",requireAdmin:!0},{icon:"mdi-update",text:"Update Studio",route:"/",requireAdmin:!0}]}]}},computed:{auth:function(){return!!this.$store.getters.isAuth&&this.$store.getters.isAuth},admin:function(){return this.$store.getters.user.admin},filterdList:function(){var t=this;return this.admin?this.cards:this.cards.map((function(e){return Object(O["a"])(Object(O["a"])({},e),{},{links:e.links.filter((function(e){return e.requireAdmin===t.admin}))})}))}},methods:{onSubmit:function(){this.$store.dispatch("dashboard")}},created:function(){this.onSubmit()}}),j=S,k=(i("1732"),i("b0af")),L=i("99d9"),D=i("62ad"),E=i("a523"),I=i("132d"),T=i("adda"),U=i("8860"),N=i("da13"),M=i("1800"),R=i("5d23"),W=i("0fd9"),B=Object(c["a"])(j,q,P,!1,null,"020c6d37",null),G=B.exports;m()(B,{VCard:k["a"],VCardActions:L["a"],VCardTitle:L["b"],VCol:D["a"],VContainer:E["a"],VContent:y["a"],VIcon:I["a"],VImg:T["a"],VList:U["a"],VListItem:N["a"],VListItemAction:M["a"],VListItemContent:R["a"],VListItemTitle:R["b"],VRow:W["a"]});var F=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("v-content",{attrs:{app:""}},[i("div",{attrs:{id:"signup"}},[i("div",{staticClass:"signup-form"},[i("form",{on:{submit:function(e){return e.preventDefault(),t.onSubmit(e)}}},[i("div",{staticClass:"input",class:{invalid:t.$v.email.$error}},[i("label",{attrs:{for:"email"}},[t._v("Email")]),i("input",{directives:[{name:"model",rawName:"v-model",value:t.email,expression:"email"}],attrs:{type:"email",id:"email"},domProps:{value:t.email},on:{blur:function(e){return t.$v.email.$touch()},input:function(e){e.target.composing||(t.email=e.target.value)}}}),i("label",{attrs:{for:"admin"}},[t._v("Administrator ?")]),i("select",{directives:[{name:"model",rawName:"v-model",value:t.admin,expression:"admin"}],attrs:{id:"admin"},on:{change:function(e){var i=Array.prototype.filter.call(e.target.options,(function(t){return t.selected})).map((function(t){var e="_value"in t?t._value:t.value;return e}));t.admin=e.target.multiple?i:i[0]}}},[i("option",{attrs:{value:"true"}},[t._v("True")]),i("option",{attrs:{value:"false"}},[t._v("False")])]),t.$v.email.email?t._e():i("p",[t._v("Please provide a valid email address.")]),i("p",{attrs:{id:"emailerror"}},[t._v(t._s(this.$store.state.emailerror))])]),i("div",{staticClass:"input",class:{invalid:t.$v.password.$error}},[i("label",{attrs:{for:"password"}},[t._v("Password")]),i("input",{directives:[{name:"model",rawName:"v-model",value:t.password,expression:"password"}],attrs:{type:"password",id:"password"},domProps:{value:t.password},on:{blur:function(e){return t.$v.password.$touch()},input:function(e){e.target.composing||(t.password=e.target.value)}}}),t.$v.password.$error?i("p",[t._v("password should be minimal 8 alphanumeric include 1 number & 1 alphabet")]):t._e()]),i("div",{staticClass:"input",class:{invalid:t.$v.confirmPassword.$error}},[i("label",{attrs:{for:"confirm-password"}},[t._v("Confirm Password")]),i("input",{directives:[{name:"model",rawName:"v-model",value:t.confirmPassword,expression:"confirmPassword"}],attrs:{type:"password",id:"confirm-password"},domProps:{value:t.confirmPassword},on:{blur:function(e){return t.$v.confirmPassword.$touch()},input:function(e){e.target.composing||(t.confirmPassword=e.target.value)}}}),t.$v.confirmPassword.$error?i("p",[t._v("password doesn't match")]):t._e()]),i("p",{attrs:{id:"register"}},[t._v(t._s(this.$store.state.register_message))]),i("div",{staticClass:"submit"},[i("v-btn",{attrs:{type:"submit",disabled:t.$v.$invalid,light:"",outlined:"",color:"black"}},[t._v("Submit")])],1)])])])])},H=[],J=i("b5ae"),Q={data:function(){return{email:"",password:"",confirmPassword:"",admin:!1}},validations:{email:{required:J["required"],email:J["email"]},password:{required:J["required"],minLen:Object(J["minLength"])(8)},confirmPassword:{sameAs:Object(J["sameAs"])((function(t){return t.password}))}},methods:{onSubmit:function(){var t={email:this.email,password:this.password,admin:this.admin};this.$store.dispatch("register",t)}}},Z=Q,Y=(i("c8d3"),i("8336")),z=Object(c["a"])(Z,F,H,!1,null,"3e6029cc",null),K=z.exports;m()(z,{VBtn:Y["a"],VContent:y["a"]});var X=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("v-content",{attrs:{app:""}},[i("div",{attrs:{id:"signin"}},[i("div",{staticClass:"signin-form"},[i("form",{on:{submit:function(e){return e.preventDefault(),t.onSubmit(e)}}},[i("div",{staticClass:"input"},[i("label",{attrs:{for:"email"}},[t._v("Email")]),i("input",{directives:[{name:"model",rawName:"v-model",value:t.email,expression:"email"}],attrs:{type:"email",id:"email"},domProps:{value:t.email},on:{blur:function(e){return t.$v.email.$touch()},input:function(e){e.target.composing||(t.email=e.target.value)}}})]),i("div",{staticClass:"input"},[i("label",{attrs:{for:"password"}},[t._v("Password")]),i("input",{directives:[{name:"model",rawName:"v-model",value:t.password,expression:"password"}],attrs:{type:"password",id:"password"},domProps:{value:t.password},on:{blur:function(e){return t.$v.password.$touch()},input:function(e){e.target.composing||(t.password=e.target.value)}}})]),i("p",{attrs:{id:"error"}},[t._v(t._s(this.$store.state.login_message))]),i("div",{staticClass:"submit"},[i("v-btn",{staticClass:"mr-6",attrs:{type:"submit",disabled:t.$v.$invalid,light:"",outlined:"",color:"black"}},[t._v("Sign in")])],1)])])])])},tt=[],et={data:function(){return{email:"",password:""}},validations:{email:{required:J["required"]},password:{required:J["required"]}},methods:{onSubmit:function(){var t={email:this.email,password:this.password};this.$store.dispatch("login",t),this.email="",this.password=""}}},it=et,rt=(i("0cf6"),Object(c["a"])(it,X,tt,!1,null,"a9eebfca",null)),at=rt.exports;m()(rt,{VBtn:Y["a"],VContent:y["a"]}),r["a"].use(h["a"]);var nt=[{path:"/",name:"Home",component:V},{path:"/register",name:"Register",component:K},{path:"/login",name:"Login",component:at},{path:"/dashboard",name:"Dashboard",component:G},{path:"*",redirect:"/"}],ot=new h["a"]({mode:"history",routes:nt}),st=i("f309");r["a"].use(st["a"]);var ut=new st["a"]({}),lt=i("8468"),ct=(i("ac1f"),i("5319"),i("2f62")),dt=i("bc3a"),mt=i.n(dt);r["a"].use(ct["a"]);var pt=new ct["a"].Store({state:{user:{email:"",admin:!1},isAuth:!1,serverUrl:"http://localhost:8080",login_message:"",register_message:""},getters:{user:function(t){return t.user},isAuth:function(t){return t.isAuth}},mutations:{clearAuthData:function(t){t.isAuth="",t.user={}},authUser:function(t,e){t.isAuth=!0,t.email=e.email,t.user.admin="true"===e.admin}},actions:{register:function(t,e){var i=this;Object(lt["a"])(t),mt.a.post("".concat(this.state.serverUrl,"/register"),{email:e.email,password:e.password,confirmPassword:e.confirmPassword,admin:e.admin}).then((function(t){i.state.register_message=t.data.Response,setTimeout((function(){i.state.register_message=""}),3e3)})).catch((function(t){console.log(t)}))},login:function(t,e){var i=this,r=t.commit;mt.a.post("".concat(this.state.serverUrl,"/login"),{email:e.email,password:e.password}).then((function(t){i.state.login_message=t.data.Response,"Login Successful"===t.data.Response&&(r("authUser",{email:e.email,admin:t.data.Admin}),ot.push({name:"Dashboard"})),setTimeout((function(){i.state.login_message=""}),2e3)})).catch((function(t){console.log("error! + ".concat(t))}))},logout:function(t){var e=t.commit;e("clearAuthData"),ot.replace("/")}}}),ft=i("076e"),vt=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("v-navigation-drawer",{attrs:{app:"","expand-on-hover":"",permanent:""}},[i("v-list",{attrs:{dense:"",flat:""}},[t._l(t.filterdList,(function(e){return i("v-list-item",{key:e.text,attrs:{link:"",to:e.route}},[i("v-list-item-action",[i("v-icon",[t._v(t._s(e.icon))])],1),i("v-list-item-content",[i("v-list-item-title",[t._v(t._s(e.text))])],1)],1)})),t.auth?i("v-list-item",{attrs:{id:"logout"},on:{click:t.onLogout}},[i("v-list-item-action",[i("v-icon",[t._v("mdi-logout-variant")])],1),i("v-list-item-content",[i("v-list-item-title",[t._v("Logout")])],1)],1):t._e()],2)],1)},ht=[],bt={computed:{auth:function(){return!!this.$store.getters.isAuth&&this.$store.getters.isAuth},filterdList:function(){var t=this;return this.links.filter((function(e){return e.requireAuth===t.auth}))}},methods:{onLogout:function(){this.$store.dispatch("logout")}},data:function(){return{links:[{icon:"mdi-pencil",text:"Register",route:"/register",requireAuth:!1},{icon:"mdi-account",text:"Login",route:"/login",requireAuth:!1},{icon:"mdi-view-dashboard",text:"Dashboard",route:"/dashboard",requireAuth:!0}]}}},gt=bt,wt=(i("8a0f"),i("f774")),_t=Object(c["a"])(gt,vt,ht,!1,null,"19470fcc",null),xt=_t.exports;m()(_t,{VIcon:I["a"],VList:U["a"],VListItem:N["a"],VListItemAction:M["a"],VListItemContent:R["a"],VListItemTitle:R["b"],VNavigationDrawer:wt["a"]}),r["a"].use(n.a),r["a"].config.productionTip=!1,r["a"].component("myfooter",ft["default"]),r["a"].component("mycontent",V),r["a"].component("mynav",xt),new r["a"]({router:ot,vuetify:ut,store:pt,render:function(t){return t(v)}}).$mount("#app")},"85ec":function(t,e,i){},"8a0f":function(t,e,i){"use strict";i("f16b")},b294:function(t,e,i){},b943:function(t,e,i){"use strict";i("d600")},c8d3:function(t,e,i){"use strict";i("b294")},d600:function(t,e,i){},f16b:function(t,e,i){}});
//# sourceMappingURL=app.fef11a9a.js.map