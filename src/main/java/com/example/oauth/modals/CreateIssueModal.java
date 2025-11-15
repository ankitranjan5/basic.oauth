package com.example.oauth.modals;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateIssueModal {

    private Fields fields;

    public CreateIssueModal() {}

    public Fields getFields() {
        return fields;
    }

    public void setFields(Fields fields) {
        this.fields = fields;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Fields {
        private Project project;
        private String summary;
        private Description description;

        // name must match JSON key "issuetype"
        @JsonProperty("issuetype")
        private IssueType issuetype;

        public Fields() {}

        public Project getProject() {
            return project;
        }

        public void setProject(Project project) {
            this.project = project;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public Description getDescription() {
            return description;
        }

        public void setDescription(Description description) {
            this.description = description;
        }

        public IssueType getIssuetype() {
            return issuetype;
        }

        public void setIssuetype(IssueType issuetype) {
            this.issuetype = issuetype;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Project {
        private String key;

        public Project() {}

        public Project(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class IssueType {
        private String name;

        public IssueType() {}

        public IssueType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Description {
        private String type;
        private int version;
        private List<ParagraphNode> content;

        public Description() {}

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public List<ParagraphNode> getContent() {
            return content;
        }

        public void setContent(List<ParagraphNode> content) {
            this.content = content;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ParagraphNode {
        private String type;
        private List<TextNode> content;

        public ParagraphNode() {}

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<TextNode> getContent() {
            return content;
        }

        public void setContent(List<TextNode> content) {
            this.content = content;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class TextNode {
        private String type;
        private String text;

        public TextNode() {}

        public TextNode(String type, String text) {
            this.type = type;
            this.text = text;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateIssueModal)) return false;
        CreateIssueModal that = (CreateIssueModal) o;
        return Objects.equals(fields, that.fields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fields);
    }
}
