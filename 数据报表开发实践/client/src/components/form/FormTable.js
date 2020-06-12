import React, { Component } from 'react';
import { Table, Icon, Popconfirm } from 'antd';
import moment from 'moment';

export default class FormTable extends Component{
    constructor(props){
        super(props);
    }
    render(){
        const { checkChange, onDelete, editClick, dataSource, loading } = this.props;
        const rowSelection = {
                onChange: checkChange,
                getCheckboxProps: record => ({
                disabled: record.name === 'Disabled User', // Column configuration not to be checked
            }),
        };
        const columns = [{
            title: '客户号',
            dataIndex: 'cust_id',
            width: 80,
        }, {
            title: '客户姓名',
            dataIndex: 'surname',
            onFilter: (value, record) => record.surname.indexOf(value) === 0,
            width: 80,
        },{
            title: '性别',
                dataIndex: 'gender',
                width: 80
        },{
            title: '生日',
            dataIndex: 'birthday',
            sorter: (a, b) => a.birthday - b.birthday,
            width: 80,
        },{
            title: '教育状况',
            dataIndex: 'educa_des',
            width: 180,
        },{
            title: '婚姻状况',
            dataIndex: 'mar_des',
            width: 120,
        },{
            title: '住址',
            dataIndex: 'address',
            width:140,
        },{
            title: '操作',
            dataIndex: 'opera',
            width:100,
            render: (text, record) =>
                <div className='opera'>
                    <span onClick={() => editClick(record.key)}>
                         <Icon type="edit" /> 修改
                    </span><br />
                    <span><Popconfirm title="确定要删除吗?" onConfirm={() => onDelete(record.key)}><Icon type="minus-square-o" /> 删除 </Popconfirm></span>
                </div>
        }];
        return(
            <Table
                rowSelection={rowSelection}
                
                columns={columns}
                dataSource={dataSource}
                bordered={true}
                scroll={{x:'100%'}}
                className='formTable'
                loading={loading}
            />
        )
    }
}
