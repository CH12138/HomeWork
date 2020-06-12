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
            title: '交易id',
            dataIndex: 'trans_id',
            width: 80,
        }, {
            title: '客户号',
            dataIndex: 'cust_id',
            width: 80,
        },{
            title: '账户号',
                dataIndex: 'account',
                width: 80
        },{
            title: '账单月',
            dataIndex: 'month_nbr',
            sorter: (a, b) => a.month_nbr - b.month_nbr,
            width: 80,
        },{
            title: '卡号',
            dataIndex: 'card_nbr',
            width: 180,
        },{
            title: '交易流水号',
            dataIndex: 'tranno',
            width: 120,
        },{
            title: '交易金额',
            dataIndex: 'bill',
            width:140,
        },{
            title: '交易日期',
            dataIndex: 'txn_datetime',
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
