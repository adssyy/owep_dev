/*******************
 *版权所有 CopyRight(c) 快程乐码信息科技有限公司所有，未经授权，不得复制转发
 *
 */

package com.kclm.owep.dto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author: ZhangQi
 * @version:v1.0
 * @create: 2020/7/14 9:06
 * @description: 节点
 **/
public class NodeDTO {
    /**
     * 文本信息
     */
    private String text;
    /**
     * 附加信息 放ID
     */
    private String[] tags;
    /**
     * 子节点
     */
    private List<NodeDTO> nodes;

    public NodeDTO() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NodeDTO{");
        sb.append("text='").append(text).append('\'');
        sb.append(", tags=").append(Arrays.toString(tags));
        sb.append(", nodes=").append(nodes);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodeDTO nodeDTO = (NodeDTO) o;
        return Objects.equals(text, nodeDTO.text) &&
                Arrays.equals(tags, nodeDTO.tags);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(text);
        result = 31 * result + Arrays.hashCode(tags);
        return result;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public List<NodeDTO> getNodes() {
        return nodes;
    }

    public void setNodes(List<NodeDTO> nodes) {
        this.nodes = nodes;
    }
}
